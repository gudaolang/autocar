import React from 'react';
import '../../public/css/shop.pcss'

class Index extends React.Component {
    constructor(props) {
        super(props);
        this.state = {seconds: 0};
    }

    tick() {
        this.setState(prevState => ({
            seconds: prevState.seconds + 1
        }));
    }

    componentDidMount() {
        this.interval = setInterval(() => this.tick(), 1000);
    }

    componentWillUnmount() {
        clearInterval(this.interval);
    }

    render() {
        return (
            <div className="cont">
                <div className="index">
                    这是商城页
                </div>
            </div>
        );
    }
}

export default Index;