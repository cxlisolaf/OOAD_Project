<%--
  Created by IntelliJ IDEA.
  User: ellie
  Date: 12/8/17
  Time: 6:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="common/header.jspf"%>


<div class="container">
    <h3>Add Ingredient</h3>

    <form:form name="myForm" method="post" commandName="ingredients">
        <form:hidden path="ingredientId" />

        <fieldset class="form-group">
            <form:label path="IngredientName" class="col-md-1 control-label">Ingredient: </form:label>
            <div class="col-md-5">
                <form:select path="ingredientName" class="form-control" id="IngredientName"
                             required="required">
                    <option value="NONE" label="--- Select ---" />
                    <option value="egg">Egg</option>
                    <option value="milk">Milk</option>
                    <option value="sugar">Sugar</option>
                    <option value="salt">Salt</option>
                    <option value="tofu">Tofu</option>
                    <option value="flour">Flour</option>
                    <option value="cream">Cream</option>

                </form:select>
                <form:errors path="ingredientName" cssClass="text-warning" />
            </div>
        </fieldset>


        <fieldset class="form-group">
            <form:label path="ingredientQuantity" class="col-md-1 control-label">Quantity: </form:label>
            <div class="col-md-5">
                <form:select path="ingredientQuantity" class="form-control" id="quantity"
                             required="required">
                    <option value="NONE" label="--- Select ---" />
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                    <option>6</option>
                </form:select>
                <form:errors path="ingredientQuantity" cssClass="text-warning" />
            </div>
        </fieldset>

        <input class="btn btn-success" type="submit" value="Submit" />
    </form:form>

</div>