import React, { Component } from 'react';
import './App.css';
import ListTarefasComponents from './component/ListTarefasComponents';

class App extends Component {
  render() {
    return (
      <div className="container">
        <ListTarefasComponents />
      </div>
    );
  }
}

export default App;
