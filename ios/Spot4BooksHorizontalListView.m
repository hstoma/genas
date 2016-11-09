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
  float currentOffset;
  long currentPosition;
}

const long CELLS_COUNT = 3000;
const long CELL_WIDTH = 120;
const long CELL_HEIGHT = 170;
const long CELL_MARGIN = 15;

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
    [flowLayout setItemSize:CGSizeMake(CELL_WIDTH, CELL_HEIGHT)];
    [flowLayout setScrollDirection:UICollectionViewScrollDirectionHorizontal];
    flowLayout.minimumLineSpacing = CELL_MARGIN;
    flowLayout.minimumInteritemSpacing = 0.0;
    _collectionView = [[UICollectionView alloc] initWithFrame:CGRectMake(0,0, self.frame.size.width, self.frame.size.height) collectionViewLayout:flowLayout];
    [_collectionView registerClass:[Spot4BooksCell class] forCellWithReuseIdentifier:@"Spot4BooksCell"];
    [_collectionView setBackgroundColor:[UIColor clearColor]];
    [_collectionView setDelegate:self];
    [_collectionView setDataSource:self];
    [_collectionView setScrollEnabled:YES];
    _collectionView.pagingEnabled = NO;
    [_collectionView setShowsHorizontalScrollIndicator:NO];
    [_collectionView setShowsVerticalScrollIndicator:NO];
    [self addSubview:_collectionView];
  }
}

- (void)scrollViewWillEndDragging:(UIScrollView *)scrollView withVelocity:(CGPoint)velocity targetContentOffset:(inout CGPoint *)targetContentOffset
{
  
  float startOffset = scrollView.contentOffset.x;
    float newTargetOffset = 0;
  if (currentOffset>startOffset) {
    newTargetOffset = currentOffset - CELL_WIDTH - CELL_MARGIN;
    currentOffset = newTargetOffset;
  } else {
    newTargetOffset = currentOffset + CELL_WIDTH + CELL_MARGIN;
    currentOffset = newTargetOffset;
  }

  
  targetContentOffset->x = currentOffset;
  [scrollView setContentOffset:CGPointMake(newTargetOffset, scrollView.contentOffset.y) animated:YES];
  /*float targetOffset = targetContentOffset->x;
  float newTargetOffset = 0;
  
  if (targetOffset > currentOffset)
    newTargetOffset = ceilf(currentOffset / pageWidth) * pageWidth;
  else
    newTargetOffset = floorf(currentOffset / pageWidth) * pageWidth;
  
  if (newTargetOffset < 0)
    newTargetOffset = 0;
  else if (newTargetOffset > scrollView.contentSize.width)
    newTargetOffset = scrollView.contentSize.width;
  
  targetContentOffset->x = currentOffset;
  [scrollView setContentOffset:CGPointMake(newTargetOffset, scrollView.contentOffset.y) animated:YES];*/
  
}


- (void)didMoveToWindow {
  [super didMoveToWindow];
  [self setStartPosition];
}

- (void)setStartPosition {
  [super layoutSubviews];
  long startPosition = CELLS_COUNT/2 - CELLS_COUNT/2 % [self._itemsArray count];
  currentPosition = startPosition;
  NSLog(@"----------------%ld", currentPosition);
  
  
  currentOffset = (startPosition) * CELL_WIDTH + startPosition * CELL_MARGIN + CELL_WIDTH/2 - self.frame.size.width/2;
  NSLog(@"----------------%f",currentOffset);
  NSLog(@"----------------%f",self.frame.size.width);
  
  [_collectionView setContentOffset:CGPointMake(currentOffset, _collectionView.contentOffset.y) animated:NO];
  //NSIndexPath *newIndexPath = [NSIndexPath indexPathForItem:startPosition inSection:0];
  //[_collectionView scrollToItemAtIndexPath:newIndexPath atScrollPosition:UICollectionViewScrollPositionCenteredHorizontally animated:NO];
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
  return CGSizeMake(CELL_WIDTH, self.frame.size.height);
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
  
  
  [cell setRealBounds:CGSizeMake(CELL_WIDTH, CELL_HEIGHT)];
  return cell;
}

@end
