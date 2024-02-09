import  api from "../config/http-client.gateway"


const getMovies = async (pagination)=> {
    try {
        const response = await api.doGet("movie/page", {params: pagination})
        return response
    } catch (error) {
        throw new Error(error)
    }
}


const saveMovie = async (movie) =>{
    try {
        const response = await api.doPost("movie/", movie)
        return response
    } catch (error) {
        throw new Error(error)
    }
}


const changeStatus = async(idMovie) => {
    try {
        const response = await api.doDelete(`movie/${+idMovie}`)
        return response
    } catch (error) {
        throw new Error(error)
    }
}

export default {getMovies, saveMovie, changeStatus}