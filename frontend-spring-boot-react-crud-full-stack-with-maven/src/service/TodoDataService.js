import axios from 'axios'

const API_URL = 'http://localhost:8080'

class CourseDataService {

    retrieveAllTarefas() {
        //console.log('executed service')
        return axios.get(`${API_URL}/tarefas`);
    }

    retrieveTarefa(id) {
        //console.log('executed service')
        return axios.get(`${API_URL}/tarefa/${id}`);
    }

    deleteTarefa(id) {
        //console.log('executed service')
        return axios.delete(`${API_URL}/tarefa/${id}`);
    }

    updateTarefa(id, tarefa) {
        //console.log('executed service')
        return axios.put(`${API_URL}/tarefa/${id}`, tarefa);
    }

    createTarefa(name, tarefa) {
        //console.log('executed service')
        return axios.post(`${API_URL}/tarefa/`, tarefa);
    }
}

export default new CourseDataService()