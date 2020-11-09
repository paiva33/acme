import React, { Component } from 'react'
import TodoDataService from '../service/TodoDataService';

const INSTRUCTOR = 'in28minutes'

class ListTarefasComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            tarefas: [],
            message: null
        }
        this.deleteCourseClicked = this.deleteCourseClicked.bind(this)
        this.updateCourseClicked = this.updateCourseClicked.bind(this)
        this.addCourseClicked = this.addCourseClicked.bind(this)
        this.refreshTarefas = this.refreshTarefas.bind(this)
    }

    componentDidMount() {
        this.refreshCourses();
    }

    refreshTarefas() {
        TodoDataService.retrieveAllTarefas()
            .then(
                response => {
                    this.setState({ tarefas: response.data })
                }
            )
    }

    deleteCourseClicked(id) {
        CourseDataService.deleteCourse(INSTRUCTOR, id)
            .then(
                response => {
                    this.setState({ message: `Delete of course ${id} Successful` })
                    this.refreshCourses()
                }
            )

    }

    addCourseClicked() {
        this.props.history.push(`/courses/-1`)
    }

    updateCourseClicked(id) {
        console.log('update ' + id)
        this.props.history.push(`/courses/${id}`)
    }

    render() {
        console.log('render')
        return (
            <div className="container">
                <h3>Lista de Tarefas</h3>
                {this.state.message && <div class="alert alert-success">{this.state.message}</div>}
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Description</th>
                                <th>Update</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.tarefas.map(
                                    course =>
                                        <tr key={tarefa.id}>
                                            <td>{course.id}</td>
                                            <td>{course.description}</td>
                                            <td><button className="btn btn-success" onClick={() => this.updateCourseClicked(course.id)}>Update</button></td>
                                            <td><button className="btn btn-warning" onClick={() => this.deleteCourseClicked(course.id)}>Delete</button></td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                    <div className="row">
                        <button className="btn btn-success" onClick={this.addCourseClicked}>Add</button>
                    </div>
                </div>
            </div>
        )
    }
}

export default ListTarefasComponent