import { useState } from "react";
import './styles.css';

export default function MyComponent({greeting}) {

    const [isAnimated, setIsAnimated] = useState(false);

    const handleClick = () => {
        setIsAnimated(!isAnimated);
        // alert("You clicked the div");
    }

    return(
        <div className={`container ${isAnimated ? 'cartwheel' : ''}`}
            onClick={handleClick}>
            <h3>My Component</h3>
            <p>Click Me!</p>
        </div>
    );
}