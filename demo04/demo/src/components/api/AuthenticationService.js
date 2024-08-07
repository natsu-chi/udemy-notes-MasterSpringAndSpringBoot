import { instance as apiClient } from './apiClient'; 

export async function executeBasicAuthentication(token) {
    apiClient.post('/basicAuthenticate', {
        headers: {
            Authorization: token
        }
    })
}

export function excuteJwtAuthenticationService(username, password) {
    apiClient.post('/authenticate', {username, password});
}