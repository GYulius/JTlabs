<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Input</title>
    <script src="jquery-3.7.1.min.js"></script>
</head>
<body>
    
    <h2>Upload a Text File</h2>
    <form action="upload" method="post" enctype="multipart/form-data">
        <input type="file" name="file" accept=".txt" required><br><br>

        <!-- CAPTCHA Image -->
        <img src="captcha" alt="CAPTCHA Image"><br>
        <input type="text" name="captchaAnswer" placeholder="Enter CAPTCHA" required><br><br>

        <input type="submit" value="Upload">
    </form>

    <script type="text/javascript">
        
$(document).ready(function() {

 $.ajaxSetup({
      cache: false
    });

    var timestamp = (new Date()).getTime();

    $("#captchaRef").click(function() {

        var timestamp = (new Date()).getTime();
        var newSrc = $("#captchaImage").attr("src").split("?");
     //  $('#captchaImage').attr('src', '').attr('src', 'Captcha.jpg');
        newSrc = newSrc[0] + "?" + timestamp;
        $("#captchaImage").attr("src", newSrc);
        $("#captchaImage").slideDown("fast");

     });
 });
</script>

<h2>Otherwise use this form</h2>

<table class="form_table_login">
        <tr><td class="form_table_td"> Email : </td>
        <td><input type="text" name="custEmail" placeholder="E-mail or Mobile" class="table_login_input" value="<%=%>"/></td></tr>
        <tr><td class="form_table_td"> Password : </td>
        <td><input type="password" name="custPassword"  placeholder="Password" class="table_login_input" value="<%=%>"/></td></tr>

    <tr><td>
	    <div id="captchaDiv">

            <td><span><img src="Captcha.jpg" border="0" id='captchaImage'></span></td>
            <span><a id="captchaRef">       <img src="../images/refresh-icon.png" style="width: 2%;"  /></a></span>
            <s:textfield label=" Captcha Code" name="j_captcha_response" size="20" maxlength="10"/>
            </div>

         </td>
     </tr>

    <tr><td ></td>
    </table>
</body>
</html>
