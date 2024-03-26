import { useParams, useNavigate } from 'react-router-dom'

const ResultsPage = () => {

    const params = useParams()
    const navigate = useNavigate()


    const calculatorReturn = () => {

        navigate("/calculator")
    }

    return(
        <div>
            <h2>The answer is {params.result}</h2>
            <button onClick={calculatorReturn}>Back to Calculator</button>
        </div>
    )

}

export default ResultsPage