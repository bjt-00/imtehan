
<div id="successAlert" class="alert alert-info" style="${(not empty message?'':'display:none')}">
  <strong>Info!</strong> ${(not empty message?message:'')}
</div>
  <script>
  setTimeout(function(){$('#successAlert').fadeOut("slow");},5000);
  </script>
