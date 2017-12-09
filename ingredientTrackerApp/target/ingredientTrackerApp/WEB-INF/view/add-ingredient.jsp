<%--
  Created by IntelliJ IDEA.
  User: ellie
  Date: 12/8/17
  Time: 6:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="common/header.jspf"%>


<div class="container">
    <h1>Add Ingredient</h1>

    <form:form name="myForm" method="post" commandName="ingredient">
        <form:hidden path="eventId" />

        <fieldset class="form-group">
            <form:label path="eventType" class="col-md-1 control-label">Sport: </form:label>
            <div class="col-md-5">
                <form:select path="name" class="form-control" id="type"
                             required="required" onChange="showCourt(this.selectedIndex);">
                    <option value="NONE" label="--- Select ---" />
                    <option value="egg">Egg</option>
                    <option value="milk">Milk</option>
                    <option value="sugar">Sugar</option>
                    <option value="salt">Salt</option>
                    <option value="tofu">Tofu</option>
                    <option value="flour">Flour</option>
                    <option value="cream">Cream</option>

                </form:select>
                <form:errors path="eventType" cssClass="text-warning" />
            </div>
        </fieldset>

        <fieldset class="form-group">
            <form:label path="eventDate" class="col-md-1 control-label">Date: </form:label>
            <div class="col-md-5">
                <div class="input-group">
                    <form:input class="form-control" id="date" name="date"
                                placeholder="MM/DD/YYYY" type="text" path="eventDate"/>
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"> </i>
                    </div>
                </div>
            </div>
        </fieldset>

        <fieldset class="form-group">
            <form:label path="eventTime" class="col-md-1 control-label">Time: </form:label>
            <div class="col-md-5">
                <form:select path="eventTime" class="form-control" id="time"
                             required="required">
                    <option value="NONE" label="--- Select ---" />
                    <option>08:00-10:00</option>
                    <option>10:00-12:00</option>
                    <option>13:00-15:00</option>
                    <option>15:00-17:00</option>
                    <option>17:00-19:00</option>
                    <option>19:00-21:00</option>
                </form:select>
                <form:errors path="eventTime" cssClass="text-warning" />
            </div>
        </fieldset>

        <fieldset class="form-group">
            <form:label path="eventPlace" class="col-md-1 control-label">Place: </form:label>
            <div class="col-md-5">
                <form:select path="eventPlace" class="form-control" id="place"
                             required="required">
                    <option value="" label="--- Select ---" />
                </form:select>
                <form:errors path="eventPlace" cssClass="text-warning" />
            </div>
        </fieldset>
        <input class="btn btn-success" type="submit" value="Submit" />
    </form:form>

</div>