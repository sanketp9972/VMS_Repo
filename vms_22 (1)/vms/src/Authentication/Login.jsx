import React, { useState } from 'react';
import '../styles/login.css';
import { MDBContainer, MDBCol, MDBRow, MDBInput, MDBCheckbox } from 'mdb-react-ui-kit';

function Login() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [emailError, setEmailError] = useState('');
  const [passwordError, setPasswordError] = useState('');

  const validateInputs = () => {
    let isValid = true;

    if (!email) {
      setEmailError('Email address is required');
      isValid = false;
    } else {
      setEmailError('');
    }

    if (!password) {
      setPasswordError('Password is required');
      isValid = false;
    } else {
      setPasswordError('');
    }

    return isValid;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    
    if (validateInputs()) {
      // Perform your login logic here
      console.log('Login successful');
    }
  };

  return (
    <MDBContainer fluid className="p-3 my-5 h-custom">
      <MDBRow>
        <MDBCol col='10' md='6'>
          <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp" className="img-fluid" alt="Sample image" />
        </MDBCol>

        <MDBCol col='4' md='5'>
          <div className="d-flex flex-row align-items-center justify-content-center divider d-flex align-items-center my-4">
            <h1 className='myTitle'>Welcome To VMS</h1>
          </div>

          <form onSubmit={handleSubmit}>
            <MDBInput wrapperClass='mb-4' label='Email address' id='formControlLg' required type='email' size="lg" value={email} onChange={(e) => setEmail(e.target.value)} />
            {emailError && <div className="text-danger">{emailError}</div>}

            <MDBInput wrapperClass='mb-4' label='Password' id='formControlLg' required type='password' size="lg" value={password} onChange={(e) => setPassword(e.target.value)} />
            {passwordError && <div className="text-danger">{passwordError}</div>}

            <div className="d-flex justify-content-between mb-4">
              <MDBCheckbox name='flexCheck' value='' id='flexCheckDefault' label='Remember me' />
              <a href="!#">Forgot password?</a>
            </div>

            <div className='text-center text-md-start mt-4 pt-2'>
              <button type="submit" className="btn btn-primary">Login</button>
              <p className="small fw-bold mt-2 pt-1 mb-2">Don't have an account? <a href="register" className="link-danger">Register</a></p>
            </div>
          </form>
        </MDBCol>
      </MDBRow>
    </MDBContainer>
  );
}

export default Login;
