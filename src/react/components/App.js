import React, { Component } from 'react';
import ReactDOM from 'react-dom';

/*class App extends Component{
    constructor(props){
        super(props);
    }
    render(){
    return (
    <div>
        {props.children}
        <div>{props.target}</div>
    </div>
    );
    }
}

App.propTypes = {
    target: React.PropTypes.string.isRequired
}*/

const App = ({target}) => (
    <div> Hi World {target} </div>
);

App.propTypes = {
    target: React.PropTypes.string.isRequired
};

export default App;