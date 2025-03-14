export default function UncontrolledForm() {
    const handleSubmit = (e) =>{
        e.preventDefault();

        const formData = new FormData(e.target);

        for(let [key, value] of formData.entries()) {
            console.log(`${key}: ${value}`);
        }
    }

    return (
        <div className="container">
            <form className="form-horizontal"
                onSubmit={handleSubmit}>
                <div className="form-group">
                    <label>First Name: </label>
                    <input type="text" name="firstName" className="form-control"/>
                </div>
                <div className="form-group">
                    <label>Last Name: </label>
                    <input type="text" name="lastName" className="form-control"/>
                </div>
                <div className="form-group">
                    <label>Email: </label>
                    <input type="email" name="email" className="form-control"/>
                </div>
                <button type="submit" className="btn btn-primary">Save info</button>
            </form>

        </div>
    )
 
}