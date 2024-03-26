import moment from "moment"

const NiceDates = (props) => {

    const {time} = props
    if (time == undefined)
    {
        return "undecided"
    }
    const niceTime = moment(time).format('DD/MM/YYYY hh:mm')
    return niceTime
}

export default NiceDates