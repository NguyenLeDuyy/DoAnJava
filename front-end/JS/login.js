// login.js

const loginForm = document.getElementById('login-form');
const usernameInput = document.getElementById('username');
const passwordInput = document.getElementById('password');
const loginBtn = document.getElementById('login-btn');
const errorMessage = document.getElementById('error-message');

loginBtn.addEventListener('click', (event) => {
  event.preventDefault();
  const username = usernameInput.value.trim();
  const password = passwordInput.value.trim();

  if (username === '' || password === '') {
    errorMessage.textContent = 'Please enter both username and password';
    return;
  }

  // TO DO: Implement authentication logic here
  // For now, just simulate a successful login
 // window.location.href = 'caijthemdo.html'; /* thêm link dẫn đến html khác*/
});