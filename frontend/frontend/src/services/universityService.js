import axios from "axios";

const API_URL = "http://localhost:8081/universities";

export default {
    getUniversities() {
        return axios.get(API_URL);
    },
    addUniversity(university) {
        return axios.post(API_URL, university);
    },
    updateUniversity(university) {
        return axios.put(API_URL, university);
    },
    deleteUniversity(id) {
        return axios.delete(`${API_URL}/${id}`);
    },
};
