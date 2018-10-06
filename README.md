# book_xml_service

Simple web service which takes one POST:http://localhost:8080/books method, and gives response as XML format.
service takes requests as :

```
<?xml version="1.0"?>
<catalog>
    <book id="bk101">
        <author>Ralls, Kim</author>
        <title>Midnight Rain</title>
        <genre>Fantasy</genre>
        <price>5.95</price>
        <publish_date>2000-12-16</publish_date>
        <description>A former architect battles corporate zombies ... </description>
    </book>
  </catalog>
```
- If service takes XML request like:  

```
<?xml version="1.0"?>
<catalog>
    <book id="bk101"/
</catalog>
```
- Than service remove book with that id if it exists in main.xml file.

- If service takes book (as XML) that has id like an book id from main.xml and book in request not empty, then service updates book attributes in main.xml file. Or adds book into main.xml if file not contains books with this id.

- If service takes empty XML request, it simple return all books from main.xml file.
