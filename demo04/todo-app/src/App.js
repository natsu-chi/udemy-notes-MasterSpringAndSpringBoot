import logo from './logo.svg';
import './App.css';
import { Component } from 'react';
import { ThirdComponent } from './components/ThirdComponent'


function App() {
  return (
    <div className="App">
      New Todo Application updated
      <FirstComponent />
      <SecondComponent></SecondComponent>
    </div>
  );
}

function FirstComponent() {
  return (
    <div className="FirstComponent">First Component</div>
  )
}

class SecondComponent extends Component {
  render() {
    return (
      <div className="SecondComponent">SecondComponent</div>
    )
  }
}

export default App;
