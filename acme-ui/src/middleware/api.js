import axios from 'axios'

const localBackend = true

axios.defaults.baseURL = 'http://localhost:8080';

export default {
  fetchTarefas: () =>
    axios
      .get('/api/tarefas')
      .then(response => response.data)
      .catch(error => error),

  saveTarefas: formData =>
    axios
      .post('/api/tarefas', { tarefa: formData })
      .then(response => response.data)
      .catch(error => error.response.data),
  
}
