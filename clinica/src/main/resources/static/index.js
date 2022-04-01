const nombre=document.getElementById("nombre");
const apellido=document.getElementById("apellido");
const matricula=document.getElementById("matricula");
const formulario=document.getElementById("formulario");

formulario.addEventListener("submit",(e)=>{
    e.preventDefault();
    const odontologo={
        license: matricula.value,
        name: nombre.value,
        lastName: apellido.value,
    }
    console.log(odontologo);
    fetch("/odontologos",{
        method:"POST",
        body:JSON.stringify(odontologo),
        headers:{
            "Content-Type":"application/json"
        }
    })
    formulario.reset();

})