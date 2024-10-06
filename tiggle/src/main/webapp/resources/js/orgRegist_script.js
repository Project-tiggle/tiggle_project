window.onload = function(){
    var photofile = document.getElementById("photofile");
    var myphoto = document.getElementById("photo");
    var deleteBtn = document.getElementById("deleteBtn");

    photofile.addEventListener('change', function(event){
        const files = event.currentTarget.files;
        const file = files[0];
        console.log(file.name);

        const reader = new FileReader();  
        reader.onload = (e) => {  
            myphoto.setAttribute('src', e.target.result);
            myphoto.setAttribute('data-file', file.name);
        };
        reader.readAsDataURL(file);  
    });

    deleteBtn.addEventListener('click', function() {
        photofile.value = '';
        myphoto.setAttribute('src', '');
        myphoto.removeAttribute('data-file');
    });
};