/**
 * Created by batmah on 16.10.16.
 */
import React, {Component} from 'react';
import ReactDOM from 'react-dom';

class App extends Component{
    constructor(props){
        super(props);
    }
    render(){
    return (
    <div>
        {this.props.children}
        <div>{this.props.target}</div>
    </div>
    );
    }
}

App.propTypes = {
    target: React.PropTypes.string.isRequired
}
export default App;
