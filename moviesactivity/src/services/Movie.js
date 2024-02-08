import  api from "../config/http-client.gateway"


const getMovies = async ()=> {
    try {
        const response = await api.doGet("link")
        return response
    } catch (error) {
        throw new Error(error)
    }
}


const saveMovie = async () =>{
    try {
        const response = await api.doPost("link")
        return response
    } catch (error) {
        throw new Error(error)
    }
}

export default {getMovies, saveMovie}