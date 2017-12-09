<%--
  Created by IntelliJ IDEA.
  User: ellie
  Date: 12/6/17
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
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
    <table class="table table-striped">
        <caption>My Pantry</caption>
        <thead>
        <tr>
            <th>Ingredient</th>
            <th>Quantity</th>
            <th></th>
        </tr>
        </thead>

        <tbody
        <c:forEach items="${IngredientEntity}" var="ingredient" varStatus="status">
            <tr>
                <td>${ingredient.ingredientName}</td>
                <td>${ingredient.ingredientQuantity}</td>
                <td>
                    <a class="btn btn-danger" href="/remove/${ingredient.ingredientId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- Modal -->
    <div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Confirmation</h4>
                </div>
                <div class="modal-body">
                    <p>Do you want to delete this ingredient?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal">No</button>
                    <a href="" class="btn btn-primary addBtn" >Yes</a>
                </div>
            </div>
        </div>
    </div>
    <div>
        <a class="btn btn-success" href="/add-ingredient">add Ingredient</a>
    </div>

</div>
<%@ include file="common/footer.jspf"%>


