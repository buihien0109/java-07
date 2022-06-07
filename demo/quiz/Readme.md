## Backend

### Admin Quiz

- Liệt kê danh sách quiz
- Tạo quiz
- Tạo quiz-item
- Xóa quiz
- Xóa quiz-item

### User Quiz

- Liệt kê danh sách quiz có random quiz + quiz-item
- Kiểm tra đáp án (Kiểm tra theo từng câu hỏi)

Quiz {
    id : int
    title : String
}

QuizAnswer {
    id : int
    title : String
    isTrue : boolean
    quizId : int
}