### MyBatis의 SqlSessionTemplate을 이용한 Demo Application API 예제입니다.

```
GET http://localhost:8000/boards

===== 예상 결과 =====
[
    {
        "boardId": 1,
        "boardTitle": "Test Board Title 1",
        "boardContents": "Test Board Contents",
        "writeId": "TestUser1",
        "modifyId": "TestUser10",
        "writeDate": "2023-06-10T00:00:00",
        "modifyDate": "2023-06-22T00:00:00"
    },
    ...
    {
        "boardId": 10,
        "boardTitle": "Test Board Title 10",
        "boardContents": "Test Board Contents",
        "writeId": "TestUser10",
        "modifyId": null,
        "writeDate": "2023-06-16T00:00:00",
        "modifyDate": null
    }
]
```

<hr>

```
GET http://localhost:8000/boards/:1

===== 예상 결과 =====
{
    "boardId": 1,
    "boardTitle": "Test Board Title 1",
    "boardContents": "Test Board Contents",
    "writeId": "TestUser1",
    "modifyId": "TestUser10",
    "writeDate": "2023-06-10T00:00:00",
    "modifyDate": "2023-06-22T00:00:00"
}
```

<hr>

```
POST http://localhost:8000/boards
Content-Type: application/json
{
    "boardTitle": "새로운 게시글 제목",
    "boardContents": "새로운 게시글 내용"",
    "writeId": "작성자1"
}

===== 예상 결과 =====
Effected Row : 1
```

<hr>

```
PUT http://localhost:8000/boards/:2
Content-Type: application/json
{
    "boardTitle": "수정된 게시글 제목",
    "boardContents": "수정된 게시글 내용",
    "modifyId": "수정자1"
}

===== 예상 결과 =====
Effected Row : 1
```

<hr>

```
DELETE http://localhost:8000/boards/:3

===== 예상 결과  =====
Effected Row : 1
```


