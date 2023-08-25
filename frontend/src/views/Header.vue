<template>
    <header className="border-bottom border-light border-5 mb-5 p-2">
        <div className="container">
            <div className="row">
                <div className="navbar navbar-expand-lg">
                    <a className="navbar-brand ms-2 fs-2 fw-bold text-black" href="https://validooo.github.io/FullStack-TodoManagement-App-React_Springboot-Java/">Todo App</a>
                    <div className="collapse navbar-collapse parent">
                        <ul className="navbar-nav">
                            <li className="nav-item fs-5"><router-link className="nav-link" to="/">Home</router-link></li>
                            <li className="nav-item fs-5"><router-link className="nav-link" to="/user/-1">Add User</router-link></li>
                            <h2 className="child">Validooo</h2>
                        </ul>
                    </div>
                    <ul className="navbar-nav">

                    </ul>
                </div>
            </div>
            </div>
        
    </header>
</template>

<script>
export default {

}
</script>

<style>
.parent {
    position: relative;
    width: 100%; /* Set an appropriate width */

   
  }

.child {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: rgb(200, 167, 202);
    padding: 5px;
    border: 1px solid gray;
  }
</style>