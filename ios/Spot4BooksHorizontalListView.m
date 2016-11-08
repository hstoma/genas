//
//  Spot4BooksHorizontalListView.m
//  genas
//
//  Created by Henadzi Stoma on 11/3/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import "Spot4BooksHorizontalListView.h"
#import "UIView+React.h"



@implementation Spot4BooksHorizontalListView {
  UICollectionView *_collectionView;
  
}

const long CELLS_COUNT = 3000;

- (instancetype)init
{
  if ((self = [super init])) {
    
    
  }
  return self;
}


@synthesize actionsDelegate;
- (void)setActionsDelegate:(id <CollectionViewActionsDelegate>)aDelegate {
  if (actionsDelegate != aDelegate) {
    actionsDelegate = aDelegate;
  }
}


- (void) initCollection {

  if (_collectionView==nil) {
    UICollectionViewFlowLayout* flowLayout = [[UICollectionViewFlowLayout alloc] init];
    [flowLayout setItemSize:CGSizeMake(120, 150)];
    [flowLayout setScrollDirection:UICollectionViewScrollDirectionHorizontal];
    _collectionView = [[UICollectionView alloc] initWithFrame:CGRectMake(0,0, self.frame.size.width, self.frame.size.height) collectionViewLayout:flowLayout];
    [_collectionView registerClass:[Spot4BooksCell class] forCellWithReuseIdentifier:@"Spot4BooksCell"];
    [_collectionView setBackgroundColor:[UIColor clearColor]];
    [_collectionView setDelegate:self];
    [_collectionView setDataSource:self];
    [_collectionView setScrollEnabled:YES];
    [_collectionView setShowsHorizontalScrollIndicator:NO];
    [_collectionView setShowsVerticalScrollIndicator:NO];
    [self addSubview:_collectionView];
  }
}

- (void)didMoveToWindow {
  [super didMoveToWindow];
  [self setStartPosition];
}

- (void)setStartPosition {
  [super layoutSubviews];
  long startPosition = CELLS_COUNT/2 - CELLS_COUNT/2 % [self._itemsArray count];
  NSIndexPath *newIndexPath = [NSIndexPath indexPathForItem:startPosition inSection:0];
  [_collectionView scrollToItemAtIndexPath:newIndexPath atScrollPosition:UICollectionViewScrollPositionLeft animated:NO];
}


- (void)reactSetFrame:(CGRect)frame
{
  [super reactSetFrame: frame];
  if (_collectionView!=nil) {
    [_collectionView setFrame:frame];
  }
}


- (NSInteger)collectionView:(UICollectionView *)collectionView numberOfItemsInSection:(NSInteger)section {
  
  return CELLS_COUNT;//[self.workingArray count];
}

- (void)collectionView:(UICollectionView *)collectionView didSelectItemAtIndexPath:(NSIndexPath *)indexPath {
  long itemPosition = indexPath.item % [self._itemsArray count];
  SimpleItemObject* obj = [self._itemsArray objectAtIndex:itemPosition];
  [actionsDelegate onTapItem:obj.labelText];
}

- (CGSize)collectionView:(UICollectionView *)collectionView layout:(UICollectionViewLayout*)collectionViewLayout sizeForItemAtIndexPath:(NSIndexPath *)indexPath{
  //SimpleItemObject* obj = [self._itemsArray objectAtIndex:indexPath.item];
  return CGSizeMake(120., self.frame.size.height);
}

- (__kindof UICollectionViewCell *)collectionView:(UICollectionView *)collectionView cellForItemAtIndexPath:(NSIndexPath *)indexPath {
  static NSString *cellIdentifier = @"Spot4BooksCell";

  Spot4BooksCell *cell = (Spot4BooksCell *)[collectionView dequeueReusableCellWithReuseIdentifier:cellIdentifier forIndexPath:indexPath];
  UIView* rootView = (UIView *)[cell viewWithTag:99];
  UIImageView* coverImage = (UIImageView *)[rootView viewWithTag:100];
  
  long itemPosition = indexPath.item % [self._itemsArray count];
  SimpleItemObject* obj = [self._itemsArray objectAtIndex:itemPosition];
  coverImage.image = [UIImage imageNamed:@"AppIcon"];
  dispatch_queue_t queue = dispatch_get_global_queue(DISPATCH_QUEUE_PRIORITY_HIGH, 0ul);
  NSURL *url = [NSURL URLWithString:obj.urlText];
  dispatch_async(queue, ^{
    NSData *data = [NSData dataWithContentsOfURL:url];
    UIImage *image = [UIImage imageWithData:data];
    dispatch_async(dispatch_get_main_queue(), ^{
      coverImage.image = image;
    });  
  });
  
  
  [cell setRealBounds:CGSizeMake(100., 170.)];
  return cell;
}

@end
