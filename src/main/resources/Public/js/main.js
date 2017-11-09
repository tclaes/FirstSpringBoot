
$(document).ready(function(){

    let url = "http://localhost:8080/cameras";
    let addForm = `
        <h1>Camera's</h1>
        <div class="form-group">

            <label for="lens">Lens</label>
            <input type="text" name="lens" id="lens" class="form-control">

            <label for="mpx">Aantal megapixel</label>
            <input type="text" name="mpx" id="mpx" class="form-control">
            <br>
            <button id="add1" type="button" class="btn btn-primary">Add now</button>
        </div>
    `;


    function showAll(){

            $.get(url,
                function(response, status){

                    if(status === "success"){
                        let r = `
                            <h1>All camera\'s</h1>
                        `;

                        response.forEach(function(element) {
                            r += `
                                <p>CameraId: ${element.id} - Lens ${element.lens} - Megapixels: ${element.aantalMpx}</p>
                                <button  data-delete="${element.id}" type="button" class="btn btn-dark m-2">Delete Camera</button>
                               
                                <button data-update="${element.id}" type="button" class="btn btn-dark m-2">Update Camera</button>   <br> 
                            `;
                        });

                            $("#main").html(r);

                    }
                },"json");
    }

    function addCamera(camera,url1){

    console.log(camera);

                $.ajax({
                    type: "POST",
                    url: url1,
                    // The key needs to match your method's input parameter (case-sensitive).
                    data: JSON.stringify(camera),
                    contentType: "application/json; charset=utf-8",
                    dataType: "text",
                    success: function(){alert(url1);showAll()}
                });

    }

    function removeCamera(id){

        console.log("Remove...");
        let delURL = url + "/" + id;
        $.ajax({

            type: "DELETE",
            url: delURL,

            success: function(){alert("deleted");showAll();}
        });

    }



    $('#show').click(function(){
        showAll();
    });

    $('#add').click(function(){
        $('#main').html(addForm);
    });

    $("body").on("click","#add1",function (){
        let lens = $("#lens").val();
        let mpx = $("#mpx").val();

        let camera = {
            lens:lens,
            aantalMpx: mpx
        }
        addCamera(camera,url);
    });


    let id = "";
    $(this).on('click', function(e){
        //console.log(e.target.id);
        //console.log($(e.target).data('delete'));
        if(typeof $(e.target).data('delete') !== 'undefined'){
            let id = $(e.target).data('delete');
            removeCamera(id);
        }


        if(typeof $(e.target).data('update') !== 'undefined'){

            let update = `
        <h1>Camera update</h1>
        <div class="form-group">

            <label for="lens">Lens</label>
            <input type="text" name="lens" id="lens" class="form-control">

            <label for="mpx">Aantal megapixel</label>
            <input type="text" name="mpx" id="mpx" class="form-control">
            <br>
            <button id="updater" type="button" class="btn btn-primary">Update</button>
        </div>
        `;

            $("#main").html(update);

             id = $(e.target).data('update');
            //console.log(id);

        }

        if(e.target.id === "updater"){
            //console.log("New: " + id);
            let lens = $("#lens").val();
            let mpx = $("#mpx").val();

            let camera = {
                id:id,
                lens:lens,
                aantalMpx: mpx
            }
            let updateURL = url + "/update";
            addCamera(camera,updateURL);
        }

        })





// $('#options').change(function(){
//     console.log($('#options :selected').val());
// })

    showAll();
});

