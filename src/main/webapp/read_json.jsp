

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>checker</title>
    </head>
    <body>
        <h1>testing api</h1>
        <button id="btn_check">check</button>
        
        <div class="server_response"></div>
        
        <script 
            src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.24.0/axios.min.js" 
            integrity="sha512-u9akINsQsAkG9xjc1cnGF4zw5TFDwkxuc9vUp5dltDWYCSmyd0meygbvgXrlc/z7/o4a19Fb5V0OUE58J7dcyw==" 
            crossorigin="anonymous" 
            referrerpolicy="no-referrer"></script>
            
        <script>
            let btnCheck = document.querySelector('#btn_check');
            let responseContainer = document.querySelector('.server_response');
            
            btnCheck.addEventListener('click', function(){
                doRequest();
            });
            
            let doRequest = function(){
                axios({
                    method: 'get',
                    url: '/sodas/resources/soda/angel',
                })
                .then(function(response){
                    
                    
                    console.log(response);
                    console.log(response.data);
                    console.log(response.name);
                    let r = JSON.parse(response.data);
                    console.log(response.data.name);
                    console.log(r);
                },function(error){
                    console.log(error);
                });
            };
            
        </script>
    </body>
</html>
