from django.db import models

# Create your models here.

class Article(models.Model):
    contents = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    # 자식을 모르니까 데려옴 
    def comments(self):
        return Comment.objects.filter(article_id = self.id)

class Comment(models.Model):
    contents = models.TextField()
    
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    # 꼭 models.CASCADE 안 해도 됨 
    article = models.ForeignKey(Article, on_delete=models.CASCADE)

