import axios from "axios";

const BASE_URL = "http:localhost:8088/api"

const registrationService =
{
    registerUser: async (bearer, name, username, password, location, genre) => {
        let data = JSON .stringify({
            name: name, 
            username: username,
            password: password, 
            location: location,
            genre: genre
        });

        let config = {
            method: "post",
            maxBodyLength: Infinity,
            url: BASE_URL + "/users",
            headers: {
                "Content-Type": "application/json",
                Authorization: `${bearer}`
            },
            data: data,
        };

        axios
        .request(config)
        .then((response) => {
            console.log(JSON.stringify(response.data));
        })
        .catch((error)=> {
            console.log(error);
        })
    }
}