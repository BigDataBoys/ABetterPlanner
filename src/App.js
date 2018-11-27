
import React, { Component } from 'react';
import { render } from "react-dom";
import Registration from './containers/Registration';
import Login from './containers/Login';

class App extends Component {
  render() {
    return (
      <div className="col-md-6">
        <h1> Welcome to A Better Planner!  </h1>
        <Registration />
      </div>
    );
  }
}
render(<App />, document.getElementById("root"));
export default App;
