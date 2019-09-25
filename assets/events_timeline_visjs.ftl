<h3>${.data_model["reserved-article-title"].data}</h3>

<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/vis/4.21.0/vis.css">

<#function getContent title content image>
  <#assign result>
    <div class="card card-horizontal card-rounded" style="width:500px">
      <div class="card-row card-row-valign-top">
        <div class="card-col-field" style="width:150px; height:150px; overflow: hidden;">
          <img
            <#if image?has_content>
              src="${image}"
            <#else>
              src="http://demo.jug.bg:8080/image/layout_set_logo?img_id=30344"
            </#if>
            class=""
            style="border-radius: 4px 0px 0px 4px; height: 150px; width: auto;"
          />
        </div>
        <div class="card-col-content card-col-gutters" style="white-space: normal;">
          <h4>${title}</h4>
          <div class="divider">&nbsp;</div>
          <p>
            <small>${content}</small>
          </p>
        </div>
      </div>
    </div>
  </#assign>
  <#return result>
</#function>

<div id="visualization">&nbsp;</div>
<link href="https://cdnjs.cloudflare.com/ajax/libs/vis/4.21.0/vis.min.css" rel="stylesheet" type="text/css" />
<script>
  Liferay.Loader.require("https://cdnjs.cloudflare.com/ajax/libs/vis/4.21.0/vis.min.js", function(vis) {

    // DOM element where the Timeline will be attached
    var container = document.getElementById("visualization");

    // Create a DataSet (allows two way data-binding)
    var items = new vis.DataSet([
      <#list title.getSiblings() as cur_event >
        {
          content: "${getContent(cur_event.getData(), cur_event.content.getData(), cur_event.image.getData())?json_string}",
          start: "${cur_event.start.getData()}",
          index: ${cur_event?index}
        } <#sep>, </#sep>
      </#list>
    ]);

    // Configuration for the Timeline
    var options = {
      // Set global item type. Type can also be specified for items individually
      // Available types: 'box' (default), 'point', 'range'
      type: "point",
      align: "left",
      minHeight: "700px",
      maxHeight: "700px",
      order: function(first, second) {
        return first.index < second.index
      }

    };

    // Create a Timeline
    var timeline = new vis.Timeline(container, items, options);

  }, function(error) {
    console.error(error)
  });
</script>
