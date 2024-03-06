import  api from "../config/http-client.gateway"
//import {decrypt} from "@/config/utils"

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

const getMoviesByName = async (name) =>{
    try {
        const response = await api.doGet(`movie/page/name/${name}`)
        return response
    } catch (error) {
        throw new Error(error)
    }
}

const getMoviesByDirector = async (name) => {
    try {
        const response = await api.doGet(`movie/page/director/${name}`)
        return response
    } catch (error) {
        throw new Error(error)
    }
}

const getMoviesByGender = async (name) => {
    try {
        const response = await api.doGet(`movie/page/gender/${name}`)
        return response
    } catch (error) {
        throw new Error(error)
    }
}


const getMoviesByRealeaseDate = async (date) => {
    try {
        const response = await api.doGet(`movie/page`, {start:date})
        return response
    } catch (error) {
        throw new Error(error)
    }
}

const deleteMovie = async (id) => {
    try {
        const response = await api.doDelete(`movie/delete/${id}`)
        return response
    } catch (error) {
        throw new Error(error)
    }

}

export default {
    getMovies, 
    saveMovie, 
    changeStatus, 
    getMoviesByName, 
    getMoviesByDirector, 
    getMoviesByGender, 
    getMoviesByRealeaseDate,
    deleteMovie
}