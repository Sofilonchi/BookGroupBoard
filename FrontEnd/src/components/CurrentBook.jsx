

const CurrentBook = (props) => {

    const { book } = props

    return(
        <div>
            <h2>The current book is: {props.title}</h2>
        </div>
    )

}

export default CurrentBook