import java.util.*

fun main() {

}

internal data class Post(
    val postId: UUID,
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val copyright: String,
    val viewsCount: Int,
    val postType: String,
    val signerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val postponedId: Int
)

private data class Comments(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
)

private data class Likes(
    val count: Int,
    val userLikes: Boolean,
    val canLike: Boolean,
    val canPublish: Boolean
)

private data class Reposts(
    val count: Int,
    val userReposted: Boolean
)

object WallService {
    private val postId: UUID = UUID.randomUUID()
    internal var postsArray = emptyArray<Post>()
    internal fun add(post: Post): Post {
        postsArray += post
        return postsArray.last()

    }

    internal fun update(post: Post): Boolean {
        var change: Boolean = false
        for ((index, value) in postsArray.withIndex()) {
            if (value.postId == post.postId) {
                postsArray[index] = value.copy(
                    id = post.id,
                    fromId = post.fromId,
                    createdBy = post.createdBy,
                    text = post.text,
                    replyOwnerId = post.replyOwnerId,
                    replyPostId = post.replyPostId,
                    friendsOnly = post.friendsOnly,
                    copyright = post.copyright,
                    viewsCount = post.viewsCount,
                    postType = post.postType,
                    signerId = post.signerId,
                    canPin = post.canPin,
                    canDelete = post.canDelete,
                    canEdit = post.canEdit,
                    isPinned = post.isPinned,
                    markedAsAds = post.markedAsAds,
                    isFavorite = post.isFavorite,
                    postponedId = post.postponedId
                )
                change = true
            } else {
                change = false
            }

        }
        return change

    }

}

