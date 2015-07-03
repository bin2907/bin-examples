<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

  <h2>Form control: input</h2>
  <p>The form below contains two input elements; one of type text and one of type password:</p>
  <form role="form">
    <div class="form-group">
      <label for="usr">Name:</label>
      <input type="text" class="form-control" id="usr">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd">
    </div>
  </form>
  
  
  
  <h2>Form control: textarea</h2>
  <p>The form below contains a textarea for comments:</p>
  <form role="form">
    <div class="form-group">
      <label for="comment">Comment:</label>
      <textarea class="form-control" rows="5" id="comment"></textarea>
    </div>
  </form>
  
  
  
  <h2>Form control: checkbox</h2>
  <p>The form below contains three checkboxes. The last option is disabled:</p>
  <form role="form">
    <div class="checkbox">
      <label><input type="checkbox" value="">Option 1</label>
    </div>
    <div class="checkbox">
      <label><input type="checkbox" value="">Option 2</label>
    </div>
    <div class="checkbox disabled">
      <label><input type="checkbox" value="" disabled>Option 3</label>
    </div>
  </form>
  
  
  <h2>Form control: inline checkbox</h2>
  <p>The form below contains three inline checkboxes:</p>
  <form role="form">
    <label class="checkbox-inline">
      <input type="checkbox" value="">Option 1
    </label>
    <label class="checkbox-inline">
      <input type="checkbox" value="">Option 2
    </label>
    <label class="checkbox-inline">
      <input type="checkbox" value="">Option 3
    </label>
  </form>
  
  
  
  <h2>Form control: radio buttons</h2>
  <p>The form below contains three radio buttons. The last option is disabled:</p>
  <form role="form">
    <div class="radio">
      <label><input type="radio" name="optradio">Option 1</label>
    </div>
    <div class="radio">
      <label><input type="radio" name="optradio">Option 2</label>
    </div>
    <div class="radio disabled">
      <label><input type="radio" name="optradio" disabled>Option 3</label>
    </div>
  </form>
  
  
  <h2>Form control: inline radio buttons</h2>
  <p>The form below contains three inline radio buttons:</p>
  <form role="form">
    <label class="radio-inline">
      <input type="radio" name="optradio">Option 1
    </label>
    <label class="radio-inline">
      <input type="radio" name="optradio">Option 2
    </label>
    <label class="radio-inline">
      <input type="radio" name="optradio">Option 3
    </label>
  </form>
  
  
  <h2>Form control: select</h2>
  <p>The form below contains two dropdown menus (select lists):</p>
  <form role="form">
    <div class="form-group">
      <label for="sel1">Select list (select one):</label>
      <select class="form-control" id="sel1">
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
      </select>
      <br>
      <label for="sel2">Mutiple select list (hold shift to select more than one):</label>
      <select multiple class="form-control" id="sel2">
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
      </select>
    </div>
  </form>
  
</div>

</body>
</html>
