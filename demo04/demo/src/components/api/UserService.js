import { instance as apiClient } from './apiClient'; 

export function retrieveAllUsers() {
    apiClient.get('/user/jpa/list')
    .then(data => {return data})
    .catch(error => console.log('Response Error: '+ error + ' url: ' + url))
}