<h3>ColumnHead tag</h3>
<hr />

<h4>Description</h4>
<br />

Allows to fill a column header with more complex content than a usual title.

<br />
<h4>Usage</h4>

You need to follow the two following steps :

 * Write anything insile the <code>columnHead</code> tag but remember to set the <code>uid</code> attribute, which is an arbitrary id for the column. 


    <datatables:columnHead uid="anyStringHere">
    	<%-- Anything you want here ! (e.g. a master checkbox) --%>
    </datatables:columnHead>


 * In the associated column, don\'t forget to set the <code>uid</code> again, with the *same value*.


    <datatables:column uid="anyStringHere">
    	<%-- Anything you want here ! (e.g. a checkbox) --%>
    </datatables:column>

    
<br />
<h4>Reference</h4>

<table id="tagReference" class="table table-striped table-bordered">
  <thead>
    <tr>
      <th>Name</th>
      <th>Description</th>
      <th>Type</th>
      <th>Value(s)</th>
      <th>Default</th>
    </tr>
  </thead>
  <tbody>
  <tr>
    <td>uid</td>
    <td>Unique arbitrary id of the column, used in relation to the column tag</td>
    <td>java.lang.String</td>
    <td></td>
    <td></td>
  </tr>
  </tbody>
</table>

<link rel="stylesheet" href="//ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css" />
<link rel="stylesheet" href="./css/tabletag.css" />
<script src="//ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js" ></script>
<script src="./js/datatables.fixedheader.min.js" ></script>
<script src="./js/tagreference.js" ></script>