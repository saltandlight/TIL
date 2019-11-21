from django.db import models
# from imagekit.models import ProcessedImageField
# from imagekit.processors import ResizeToFill, ResizeToFit
# Create your models here.

class Article(models.Model):
    contents = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    image = models.ImageField(blank=True)
    #processed image field
    # image_resized = ProcessedImageField(
    #     # source='image',
    #     upload_to = 'articles/images',
    #     processors = [ResizeToFit(200, 300)],
    #     format='JPEG',
    #     options={'quality':90}
    # )
    def comments(self):
        return Comment.objects.filter(article_id=self.id)

class Comment(models.Model):
    contents = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    article = models.ForeignKey(Article, on_delete=models.CASCADE)

