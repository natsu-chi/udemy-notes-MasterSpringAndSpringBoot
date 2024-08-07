import axios from 'axios'; // -> ES6
// const axios = require('axios'); -> Common JS


export const instance = axios.create({
    baseURL: 'http://localhost:8080'
});

// instance.defaults.headers.common['Authorization'] = AUTH_TOKEN;
// instance.defaults.headers.post['Content-Type'] = 'application/json';