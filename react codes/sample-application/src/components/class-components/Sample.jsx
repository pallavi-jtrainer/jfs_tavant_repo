import { Component } from "react";

export default class Sample extends Component {
    constructor(props){
        super(props);
        this.state = {
            name: this.props.name
        }
    }

    componentWillUnmount() {
        console.log(`Component unmounted`);
    }

    componentWillMount()
    {
        console.log(`Component mounting`);
    }

    componentDidMount() {
        console.log(`Component mounted with name: ${this.state.name}`);
    }

    render() {
        return(
            <div>
                <h1>Hello, {this.state.name}!</h1>
            </div>
        );
    }
}