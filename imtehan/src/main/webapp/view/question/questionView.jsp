<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
<p style="padding:3px;">
${orm.question}
</p>
</div>
<div class="row">
<fieldset>
	<legend>Options</legend>
		<ol>
				<c:forEach items="${orm.optionsList}" var="option" varStatus="i" >
						<li> 
						<label>
						 ${option.optionLabel}
						 </label>
						 <span class="glyphicons glyphicons-brightness-increase" title="Correct Answer is = ${option.correct}" onclick="$('#answer-${i.index}').html('${option.correct}')">Show Answer</span>
						 <span id="answer-${i.index}" style="color:green;font-weight:bold"></span>
						</li>
				</c:forEach>
		</ol>
</fieldset>
</div>