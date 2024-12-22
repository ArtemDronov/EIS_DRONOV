import { createApp } from 'vue';
import App from './App.vue';
import axios from 'axios';

axios.defaults.baseURL = 'http://localhost:8081'; // Замените на ваш бэкенд
createApp(App).mount('#app');
