from django.shortcuts import render, redirect

# Create your views here.
from .models import Article

def index(request):
    # Article Model에 있는 모든 Article을 불러움
    articles = Article.objects.all()
    context = {
        'articles':articles
    }
    return render(request, 'index.html', context)

def show(request, id):
    article = Article.objects.get(id=id)
    context = {
        'article':article
    }
    return render(request, 'show.html', context)

def new(request):
    if request.method == 'POST':
        title = request.POST['title']
        contents = request.POST['contents']
        creator = request.POST['creator']
        # Article에 하나씩 값을 집어넣음 

        article = Article.objects.create(title=title, contents=contents, creator=creator)
        return redirect('articles:show', article.id)
    else:
        return render(request, 'new.html')

def create(request):
    # Request 통해서 name으로 되어 있는 아이들의 값을 받아옴
    title = request.GET['title']
    contents = request.GET['contents']
    creator = request.GET['creator']
    # Article에 하나씩 값을 집어넣음 
    article = Article()
    article.title = title
    article.contents = contents
    article.creator = creator
    article.save()

    return redirect('articles:show', article.id)

def edit(request, id):
    # id값을 가지고 객체 꺼내옴 
    if request.method == 'POST':
        article = Article.objects.get(id=id)
        article.title = request.POST['title']
        article.contents = request.POST['contents']
        article.creator = request.POST['creator']
        article.save()

        context = {
            'article': article
        }
        return redirect('articles:show', article.id)
    else:
        article = Article.objects.get(id=id)
        context = {
            'article': article
        }
        return render(request, 'edit.html', context)

# def update(request, id):
#     article = Article.objects.get(id=id)

#     title = request.GET['title']
#     contents = request.GET['contents']
#     creator = request.GET['creator']

#     article.title = title
#     article.contents = contents
#     article.creator = creator 
#     article.save()

#     return redirect('articles:show', article.id)

def delete(request, id):
    article = Article.objects.get(id=id)
    article.delete()
    return redirect('articles:index')