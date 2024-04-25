

data class Note (val title: String, val description: String, val type: Type) {
    enum class Type { TEXTO, AUDIO }
}

val list: List<Note> = listOf(
    Note("Title 1", "Description 1", Note.Type.AUDIO),
    Note("Title 2", "Description 2", Note.Type.AUDIO),
    Note("Title 3", "Description 3", Note.Type.TEXTO),
    Note("Title 4", "Description 4", Note.Type.TEXTO),
    Note("Title 5", "Description 5", Note.Type.AUDIO),
    Note("Title 6", "Description 6", Note.Type.AUDIO),
    Note("Title 7", "Description 7", Note.Type.TEXTO),
    Note("Title 8", "Description 8", Note.Type.TEXTO),
    Note("Title 9", "Description 9", Note.Type.AUDIO),
    Note("Title 10", "Description 10", Note.Type.TEXTO),
)

