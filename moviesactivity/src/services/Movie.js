import api from "../config/http-client.gateway"
const forge = require('node-forge')

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

        // Base64-encoded public key
        const publicKeyBase64 = 'INSERT YOUR PUBLIC KEY HERE';

        // Convert base64-encoded public key to ASN.1 representation
        const publicKeyAsn1 = forge.asn1.fromDer(forge.util.decode64(publicKeyBase64));

        // Convert ASN.1 public key to Forge public key object
        const publicKey = forge.pki.publicKeyFromAsn1(publicKeyAsn1);

        // Encrypt a message with RSA-OAEP and the public key
        const message = 'Hello, World!';
        console.log()
        const encryptedMessage = publicKey.encrypt(message, 'RSA-OAEP', {
            md: forge.md.sha256.create(),
            mgf1: {
                md: forge.md.sha1.create()
            }
        });

        // Display the encrypted message
        console.log('Encrypted message:', forge.util.encode64(encryptedMessage));

        const data = JSON.stringify( movie);

        return await api.doPost("movie/", data)
    } catch (error) {
        console.log(error)
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