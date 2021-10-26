let form = document.getElementById("signUp").addEventListener('submit', signUp);

async function signUp(e){
	alert('inside signup function inside javascript');
	e.preventDefault();
	
	let username = document.getElementById("username").value;
	let password = document.getElementById("password").value;
	let firstName = document.getElementById("firstname").value;
	let lastName = document.getElementById("lastname").value;
	let email = document.getElementById("email").value;
	let rollid=document.getElementById("rollid").value;
	
	let user = {
		username,
		password,
		firstName,
		lastName,
		email,
		rollid
	}
	
	try{
		let req = await fetch('http://localhost:8080/ExpenseReimbursementSystem/api/signUp', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(user)
		});
		let res = await req.json();
		location.href = '../html/login.html';
	} catch(e){
		alert('fill out all required field to sign up');
		return;
	}
	
}