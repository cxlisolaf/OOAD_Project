<%@ include file="common/header.jspf"%>
<link rel="stylesheet"
      href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<link rel="stylesheet"
      href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>

<script type="text/javascript"
        src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>

<script
        src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $(".triggerJoin").click(function(e) {
            e.preventDefault();
            $("#myModal .joinBtn").attr("href", $(this).attr("href"));
            $("#myModal").modal();
        });
    });
</script>

<div class="container">


    <h1>Ingredient Tracker</h1>
    <img src="Boulder FL.jpg">

    <h3>Welcome!</h3>
    <form:form action="/login" method="post" class="form-horizontal">
        <fieldset class="form-group">
            <div class="col-xs-3">
                <label>new user?</label>
                <div>
                    <a class="btn btn-success" href="/register">sign up</a>
                </div>
            </div>
        </fieldset>
        <fieldset class="form-group">
            <div class="col-xs-3">
                <label>already have an account?</label>
                <div>
                    <a class="btn btn-success" href="/login">login</a>
                </div>
            </div>
        </fieldset>


    </form:form>
    <p style="color: red">${errorMsg }</p>
</div>
<%@ include file="common/footer.jspf"%>
