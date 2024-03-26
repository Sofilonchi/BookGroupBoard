import NiceDates from "./NiceDates"


const Meeting = (props) => {

    const { time } = props

    return(

        <div>
            <h2>The time for the next meeting is <NiceDates time={time}/> </h2>
        </div>
    )

}

export default Meeting