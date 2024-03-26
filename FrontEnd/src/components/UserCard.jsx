import '../styles/UserCard.css'

const UserCard = (props) => {

    const { person } = props
    const {name, username } = person

    return(
        <div>
            <p>Name: {name}</p>
            <ul>
                <li>Username: {username}</li>
            </ul>
            <button>Update</button>
            <button>Delete</button>
        </div>
    )
}
export default UserCard